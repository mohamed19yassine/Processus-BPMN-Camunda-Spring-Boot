# Projet Spring Boot avec Camunda pour la publication de vidéos sur YouTube

Ce projet illustre un processus complet, depuis l'idée initiale jusqu'à la publication finale d'une vidéo sur YouTube, en utilisant les technologies suivantes :

- JDK 17
- Spring Boot 2.7.3
- Camunda BPM 7.18.0

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les éléments suivants :

- JDK 17 (ou une version supérieure) : [lien de téléchargement](https://www.oracle.com/java/technologies/downloads/)
- Maven : [lien de téléchargement](https://maven.apache.org/download.cgi)

## Configuration du projet

1. Clonez ce dépôt Git sur votre machine locale :

   ```
   git clone https://github.com/mohamed19yassine/Processus-BPMN-Camunda-Spring-Boot.git
   ```

2. Accédez au répertoire du projet :

   ```
   cd Processus-BPMN-Camunda-Spring-Boot
   ```

3. Compilez et construisez le projet à l'aide de Maven :

   ```
   mvn clean install
   ```

## Exécution du projet

1. Démarrez l'application Spring Boot à l'aide de la commande suivante :

   ```
   mvn spring-boot:run
   ```

2. Accédez à l'interface utilisateur de Camunda en utilisant l'URL suivante :

   ```
   http://localhost:8080/camunda/app/
   ```

3. Connectez-vous à l'interface utilisateur en utilisant les identifiants par défaut (utilisateur : `demo`, mot de passe : `demo`).

4. Suivez les étapes du processus pour créer et publier une vidéo sur YouTube et Linkedin.

## Dépendances

Ce projet utilise les dépendances suivantes :

```xml
<dependencies>
    <!-- Camunda BPM Spring Boot Starter Webapp -->
    <dependency>
        <groupId>org.camunda.bpm.springboot</groupId>
        <artifactId>camunda-bpm-spring-boot-starter-webapp</artifactId>
    </dependency>

    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- H2 Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
    </dependency>

    <!-- Spring Boot Starter JDBC -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
</dependencies>
```

Assurez-vous d'ajouter ces dépendances dans la section `<dependencies>` de votre fichier `pom.xml`.

## Contributions

Les contributions à ce projet sont les bienvenues. N'hésitez pas à ouvrir des problèmes ou à soumettre des demandes de fusion (pull requests) pour améliorer ce projet.

## Licence

Ce projet est sous licence MIT. Pour plus d'informations, veuillez consulter le fichier [LICENSE](LICENSE).