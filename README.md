# Micronaut Issue example repo

## Reproduction steps

- run `./gradlew :run`
- start mcp inspector `npx  @modelcontextprotocol/inspector`
- observe Tool1 has no json-schema, while Tool2 does.

Tool1 is generated using the json-schema generator with the gradle plugin.
Tool2 is generated using ksp.

