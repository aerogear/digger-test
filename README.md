# Prerequisites
 * JDK 1.7+
 * Maven 4+
 * Optional for self managed templates - AWS credentials for S3 with component builds. (in ~/.aws/credentials)

# How to run
```
$ mvn test -Dtarget=yourTarget [OPTIONS]
```

## Targets
You need to define your targets in tagets.json. Rename targets-example.json to targets.json and update it with your values.

## Options
In CLI prepend your options with -D
* **target** - name of target Build Farm.
* **groups** - _optional_ - comma separated list of groups that should be tested. E.g: `-Dgroups=smoke,other`
* **excludedGroups** - _optional_ - comma separated list of groups that should not be tested. E.g: `-DexcludedGroups=hybrid,android` - this would only test native iOS templates and other non-android tests.
* **prefix** - _optional_ - prefix used for names of the test entities. Default value is in pom.xml.
* **fhta-url** - _optional_ - Git url to feedhenry/fh-template-apps fork that should be used for downloading templates
* **fhta-branch** - _optional_ - branch/tag of feedhenry/fh-template-apps that should be used for downloading templates
* **self-man-branch** - _optional_ - you need to pass this parameter when testing 4.x templates. Value should be branch name OR tag name from git://pkgs.devel.redhat.com/rpms/rhmap-fh-sdks-docker repo OR just "latest"(tag). For this feature you need to be on **RH VPN**


# Adding self-signed certificate to your Java keystore
```
export JENKINS_URL="jenkins.hostname.tld:443"
export CERT_ALIAS="my-self-signed-jenkins"
openssl s_client -showcerts -connect $JENKINS_URL < /dev/null | openssl x509 -outform DER > tmp_cert.der
sudo keytool -import -alias $CERT_ALIAS -keystore $JAVA_HOME/jre/lib/security/cacerts -file tmp_cert.der
```