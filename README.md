# Jenkins Environment Variable Page Decoration Plugin

https://wiki.jenkins.io/display/JENKINS/Environment+Variable+Page+Decoration+Plugin

Pretty much what it says on the tin.  Use API exposed by PageDecorator to
inject environent variables into Jenkins Pages.  Primarily useful for adding
deploy data to the footer.

This is targetted at systems that are deployed via some automated means, there
is no UI for configuration.

## Usage

You can set the following environment variables:

* `JENKINS_FOOTER_EXTRA` - Add content to the footer after the Jenkins version content.
* `JENKINS_FOOTER_EXTRA_B64` - If this is set, then `JENKINS_FOOTER_EXTRA` is base64 decoded.
* `JENKINS_HEADER_EXTRA` - Add content in the page `head` tags (e.g., css or javascript tags).
* `JENKINS_HEADER_EXTRA_B64` - If this is set, then `JENKINS_HEADER_EXTRA` is base64 decoded.

## Example

Set some environment variables:

```
export DEPLOY_TIME=$(date)
export DEPLOY_USER=${USER}
export GIT_BRANCH=$(git branch | grep \* | cut -d ' ' -f2)
export GIT_SHA=$(git rev-parse --short HEAD)
```

Create a footer template to consume the environment variables (`data.sh`):

```
echo "<span style='margin-left: 1em;'>deployed ${GIT_BRANCH}@${GIT_SHA} by ${DEPLOY_USER} at ${DEPLOY_TIME}</span>"
```

Create a base64 encoded string:

```
bash data.sh | base64 | pbcopy
```

Set the environment variables when running Jenkins (e.g., via Docker):

```
-e JENKINS_FOOTER_EXTRA="PHNwYW4gc3R5bGU9J21hcmdpbi1sZWZ0OiAxZW07Jz5kZXBsb3llZCBldnBkLXRlc3RAYWJjMTIzIGJ5IHR2b24gYXQgVGh1IE1heSAgMiAyMjozNzo1OSBFRFQgMjAxOTwvc3Bhbj4K" -e JENKINS_FOOTER_EXTRA_B64=1
```
