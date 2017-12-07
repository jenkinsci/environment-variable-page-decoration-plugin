# Jenkins Page Decoration

Use API exposed by PageDecorator to inject environent variables into Jenkins Pages.

This is targetted at systems that are deployed via some automated means, there
is no UI for configuration.

## Usage

You can set the following environment variables:

* `JENKINS_FOOTER_EXTRA` - Add content to the footer after the Jenkins version content.
* `JENKINS_HEADER_EXTRA` - Add content in the page `head` tags (e.g., css or javascript tags).
* `JENKINS_HTTP_HEADERS_EXTRA` - Add content before the `html` tag (I have no
  use case for this but the extension point is there so it is exposed here).
