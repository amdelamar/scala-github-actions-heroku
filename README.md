# CI/CD with Github Actions & Heroku

This simple Scala app shows how you can setup CI/CD with GitHub Actions and Heroku.

Requires [JDK 8](https://adoptopenjdk.net/) and [sbt](https://www.scala-sbt.org/).

## CI

Opening a Pull Request against `master` branch will run:

```bash
$ sbt compile
$ sbt test
```

You can modify what commands are executed on every PR in the [.github/workflows/master-pull-request.yml](/.github/workflows/master-pull-request.yml) file.

If the commands exit with code != 0, (e.g. if a unit test fails), then the PR wil be marked as not passing that check.

You could add more commands like linting, code coverage checks, or whatever your heart desires.
(Even deploy on PR too for end-to-end testing!)
 

## CD

After merging your Pull Request to `master` this command will run:

```bash
$ sbt stage deployHeroku
```

And your app will be pushed and deployed on Heroku in less than a minute!

_Note:_ You'll have to set a secret value for the `HEROKU_API_KEY` required to deploy your app to Heroku.
This can be done in GitHub -> Settings -> Secrets -> Add new secret.

You can modify what commands are executed on every merge in the [.github/workflows/master-push.yml](/.github/workflows/master-push.yml) file.

You could add more commands like packaging, publishing, Docker image creation, or whatever your heart desires.
 (Even modify/close GitHub issues!)
