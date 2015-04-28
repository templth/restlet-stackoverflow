## Run the server

Run the class `RestletLauncher`.

## Test the routing

Call the following request to use the class `MyServerResourceDefault`:

```
POST http://localhost:8182/app/ping
Content-Type: application/json
{
  	"name":"my name",
	"message":"my message"
}
```

Call the following request to use the class `MyServerResourceTokened`:

```
POST http://localhost:8182/app/ping
Content-Type: application/json
{
  	"name":"my name",
	"message":"my message"
  	"token":"my token"
}
```
