# mailchimpApiSpringBoot

## Setup

To make it work you need to have api.json file in resources folder. File has following structure:

    {
      "url": "https://baseUrl.api-us1.com",
      "apiKey": ""
    }



## Heroku deploy

    git push heroku master

    heroku open

## Heroku deploy with mvn plugin

    mvn clean heroku:deploy
