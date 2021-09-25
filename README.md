# CleanArch. Template (Kotlin)

Clean Arch app template written in kotlin. 

[![version](https://img.shields.io/badge/version-template.beta-y.svg)](https://semver.org)
## Libraries

[RXJava2](https://) - Reactive, asynchronous and event-based programs

[RXAndroid2](https://) - Android schedulers etc. bindings of rxjava

[Dagger2](https://) - Dependency injection

[Kotest](https://) - Testing, property testing

[Retrofit2](https://) - Networking

[Exposed](https://) - SQL Framework for kotlin

[GSON](https://) - GSON data class/json parser

## Layers

- App (DI)

- UI (Javafx/alternate presenter layer)

- Android (UI)

- Data (mapping, piping network, cache and persistence)

  - Network (external data sources)

  - Persistence (DB)

- Domain (Usecases, Entities)


## Architectural Information (Hexa,Clean,Onion..)

#### Illustration: a POC App example (Hexagonal)

![alt text](https://blog.octo.com/wp-content/uploads/2020/06/archi_hexa_en_01.png)

Principle1: Separate User-Side, Business Logic and Server-Side

Principle2: Dependencies go to the Business Logic

Principle3: boundaries are isolated with interfaces


#### Illustration: Clean Architecture

![alt text](https://miro.medium.com/max/880/1*S-F40uCJHy7ZL2hUU3VG7w.png)




## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
