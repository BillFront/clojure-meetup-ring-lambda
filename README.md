# The coolest animal from ring to AWS Lambda

It's a simple example demonstrating (check the commit history) how a ring app
can be easily transformed into an AWS Lambda function.

To run it on AWS Lambda, generate an uberjar first:

`lein uberjar`

Then you need to create the function:
```
aws lambda create-function \
      --region eu-west-1 \
      --function-name clojure-meetup-coolest-animal \
      --zip-file fileb://$(pwd)/target/uberjar/coolest-animal-ring-lambda-0.1.0-SNAPSHOT-standalone.jar \
      --role arn:aws:iam::YOUR_ACCOUNT_ID:role/lambda_basic_execution \
      --handler coolest-animal-ring-lambda.core.HandlerFn \
      --runtime java8
```

...and finally, call it:

```
aws lambda invoke \
      --invocation-type RequestResponse \
      --function-name clojure-meetup-coolest-animal \
      --region eu-west-1 \
      --payload '"elephant,turtle,camel,crocodile,poodle"' \
      out.txt
```
