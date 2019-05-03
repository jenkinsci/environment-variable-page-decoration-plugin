package io.jenkins.plugins.blue_page_decoration
//package io.jenkins.blueocean

import hudson.Extension
import io.jenkins.blueocean.BluePageDecorator

@Extension
class BluePageDecoration extends BluePageDecorator {

  String getHeaderExtra() {
    String jenkinsHeaderExtra = System.env.get('JENKINS_BLUE_HEADER_EXTRA')
    if(System.getenv('JENKINS_BLUE_HEADER_EXTRA_B64')){
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

