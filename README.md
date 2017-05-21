# JBake Templating System
To build and install this for testing, checkout the codebase and run below commands at root of the project -

```
gradlew distZip
gradlew installDist
cd build/install/jbake-ts/bin

## List releases for a template
jbake-ts -r manikmagar/jbake-future-imperfect-template


## Install particular template version
jbake-ts -t manikmagar/jbake-future-imperfect-template v1.1.0 awesome-jbake

```

It should download the template under `awesome-jbake` folder in current directory. Test baking -

```
cd awesome-jbake
jbake -b -s
```

Visit browser http://localhost:8820

Note: This is still under development.

## How to release on Github
Look at the sample [jbake template repository](https://github.com/manikmagar/jbake-future-imperfect-template).

JBake template should have below structure -

- assets
- content
- templates
- jbake.properties

To create a Github release, select these four items and create a zip. Then on Github Release page (like [this](https://github.com/manikmagar/jbake-future-imperfect-template/releases)), create a new draft release and upload this zip as an asset. It is good to use tag/versions lile v1.0.0 etc.
