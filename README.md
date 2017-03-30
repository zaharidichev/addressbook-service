# Address Book Service

This is an example of a REST style service written in Scala which can answer three questions:

- How many males are in the address book? - __3__
- Who is the oldest person in the address book - __Wes__
- How many days older is Bill than Paul - __2862__

# Running
- sbt test (runs unit tests)
- sbt run (runs the service)

# Endpoints
You have three endpoints that have been defined which have corresponding responses:

__/oldest-person__

```json
{
  "answer": "The oldest person is Wes"
}
```


__/number-males__

```json
{
  "answer": "The number of males is 3"
}
```

__/bill-and-paul-age-diff__

```json
{
  "answer": "The number of days by which Bill is older than Paul is 2862"
}
```

# Tests
Test have been written with mocked people data and can be run through SBT. The service is handling situations where we have an empty repository. For example, if for some reason the "persistence" layer does not have any data in it and yet we do a __GET__ on __/bill-and-paul-age-diff__ , what we are getting back is

```json
{
  "answer": "The number of days by which Bill is older than Paul is unknown amount of days as one of them is not in the address book"
}
```


# Deployment
Dependency injection has been provided via the standard Cake pattern in Scala. This allows us to very easily swap out repository implementations in order to do service level tests with mock data

# Deployment
Currently there is a live instance of the service running on the cloud. You can see the current price levels by doing a GET on:
```curl
http://addressbook-service.addressbook-service.9a66f1ac.svc.dockerapp.io:8083/bill-and-paul-age-diff
```
The CircleCI config as well as the docker file are both included in the repo. CI is already setup so the process goes in the following way:

* Push to the repo triggers a build
* The build system packages a docker image and pushes it to Docker Hub
* The image is automatically picked up by the Docker Cloud API and deployed on AWS