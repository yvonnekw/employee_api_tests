# employee api test

Using local json server -
http://localhost:3004/employees

## Previous baseUrl
http://dummy.restapiexample.com/api/v1

### How to install the json local server
execute the following command to get started.
```
npm install -g json-server
```
Create a db.json file with some data -
```
{
        "employees": [
        {
                    "id": 1,
                    "employee_name": "Chris Pagac DDS",
                    "employee_salary": 73878,
                    "employee_age": 61,
                    "profile_image": "https://s3.amazonaws.com/uifaces/faces/twitter/hafeeskhan/128.jpg"
        }
    ]
}
```
Start the JSON Server
```agsl
json-server --watch db.json
```
### server to use
employee_Db.json server.
Download the json server here -

git@github.com:yvonnekw/local_json_servers.git

### Check the server is running -
Head off to your browser -

http://localhost:3004/employees

### More info about json server 

Find out more here -

```agsl
https://github.com/typicode/json-server
```

## Execute the tests
Right click the any test cases and run with java.

