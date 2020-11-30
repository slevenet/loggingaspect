# loggingaspect

Подключение к проекту:

1. Добавить зависимость в pom.xml (если отсутствует):

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        
2. Перенести 2 файла в свой проект com.is.logging.logging , пакет не имеет значения, главное, чтобы компонент попал в контекст спринга.

3. Перепроверить логику в LoggingHandlerAbstract

Описание: 

LoggingControllerHandler - аспект, который работает с ресурсами, помеченные аннотацией @Controller. Он наследует LoggingHandlerAbstract,
где расположена дефолтовая логика логирования. Это сделано для того, чтобы в случае написания такого же функционала для сервиса - переиспользовать уже существующее и просто создать новый аспект.

MainController - вспомогательный класс. Переносить его не требуется

Пример работы:

2020-11-30 18:09:14.762  INFO 964 --- [nio-8080-exec-4] c.i.l.logging.LoggingControllerHandler   : Time : 2020-11-30T18:09:14.762
2020-11-30 18:09:14.762  INFO 964 --- [nio-8080-exec-4] c.i.l.logging.LoggingControllerHandler   : UserName: test
2020-11-30 18:09:14.762  INFO 964 --- [nio-8080-exec-4] c.i.l.logging.LoggingControllerHandler   : Method : com.is.logging.controllers.MainController.home
2020-11-30 18:09:14.781  INFO 964 --- [nio-8080-exec-4] c.i.l.logging.LoggingControllerHandler   : End controller : com.is.logging.controllers.MainController
