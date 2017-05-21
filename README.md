# JBake Templating System
To build and install this for testing, checkout the codebase and run below commands at root of the project -

```
gradlew distZip
gradlew installDist
cd build/install/jbake-ts

jbake-ts -t manikmagar/jbake-future-imperfect-template v1.1.0 awesome-jbake

```

It should download the template under `awesome-jbake` folder in current directory. Test baking -

```
cd awesome-jbake
jbake -b -s
```

Visit browser http://localhost:8820

Note: This is still under development.
