grails.servlet.version = "3.0"
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.fork = [
        test   : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon: true],
        run    : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        war    : [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve: false],
        console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    inherits("global") {
    }
    log "error"
    checksums true
    legacyResolve false

    repositories {
        inherits true

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        String springSecurityVersion = '3.2.5.RELEASE'

        compile "org.springframework.security:spring-security-core:$springSecurityVersion", {
            excludes 'aopalliance', 'aspectjrt', 'cglib-nodep', 'commons-collections', 'commons-logging', 'ehcache', 'fest-assert', 'hsqldb', 'jcl-over-slf4j', 'jsr250-api', 'junit', 'logback-classic', 'mockito-core', 'powermock-api-mockito', 'powermock-api-support', 'powermock-core', 'powermock-module-junit4', 'powermock-module-junit4-common', 'powermock-reflect', 'spring-aop', 'spring-beans', 'spring-context', 'spring-core', 'spring-expression', 'spring-jdbc', 'spring-test', 'spring-tx'
        }
    }

    plugins {
        build ":tomcat:7.0.55"

        compile ":vaadin:7.3.0.2"

        runtime ":hibernate4:4.3.5.5" // or ":hibernate:3.6.10.17"
    }
}
