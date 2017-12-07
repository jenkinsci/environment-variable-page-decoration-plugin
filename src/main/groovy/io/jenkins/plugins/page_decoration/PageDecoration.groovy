package io.jenkins.plugins.page_decoration

import hudson.Extension
import hudson.model.PageDecorator

@Extension
class PageDecoration extends PageDecorator {
  String getFooterExtra() {
    return System.env.get('JENKINS_FOOTER_EXTRA')
  }
  String getHeaderExtra() {
    return System.env.get('JENKINS_HEADER_EXTRA')
  }
  String getHttpHeadersExtra() {
    return System.env.get('JENKINS_HTTP_HEADERS_EXTRA')
  }
}
