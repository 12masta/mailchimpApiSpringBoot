# mailchimpApiSpringBoot

## Setup

To make it work you need to have api.json file in resources folder. File has following structure:

    {
      "url": "https://<dc>.api.mailchimp.com/3.0",
      "apiKey": ""
    }

The <dc> part of the URL corresponds to the data center for your account. For example, if the last part of your
Mailchimp API key is us6, all API endpoints for your account are available at https://us6.api.mailchimp.com/3.0/.


## Heroku deploy

    git push heroku master

    heroku open

## Heroku deploy with mvn plugin

    mvn clean heroku:deploy
