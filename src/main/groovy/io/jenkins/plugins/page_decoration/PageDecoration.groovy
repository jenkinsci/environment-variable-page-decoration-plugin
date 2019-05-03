package io.jenkins.plugins.page_decoration

import hudson.Extension
import hudson.model.PageDecorator

@Extension
class PageDecoration extends PageDecorator {

  String getFooterExtra() {
    String jenkinsFooterExtra = System.env.get('JENKINS_FOOTER_EXTRA')
    if(System.getenv('JENKINS_FOOTER_EXTRA_B64')){
      return decodeB64(jenkinsFooterExtra)
    }
    return jenkinsFooterExtra
  }

  String getHeaderExtra() {
    String jenkinsHeaderExtra = System.env.get('JENKINS_HEADER_EXTRA')
    if(System.getenv('JENKINS_HEADER_EXTRA_B64')){
      return decodeB64(jenkinsHeaderExtra)
    }
    return jenkinsHeaderExtra
  }

  String decodeB64(valueB64){
    byte[] decodedContent_b = valueB64.decodeBase64()
    String decodedContent = new String(decodedContent_b)
    return decodedContent
  }

}
