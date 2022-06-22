
# Countries API

An API with a list of countries, with CRUD endpoints.
## Run Locally

Clone the project

```bash
  git clone https://github.com/bmayegun/Country-API.git
```

Go to the project directory

```bash
  cd Country-API
```

Start the server from IDE

```bash
  Open project in preferred IDE and run the maven spring-boot:run plugin
```

Start the server from command line

```bash
  mvn spring-boot:run
```


## Endpoints
Find list of endpoints at http://serverName:applicationPort/swagger-ui/index.html#/
#### Get all countries

```http
  GET /countries
```
| Path Variable | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `page`      | `string` | **Optional**. Result page to return |
| `size`      | `string` | **Optional**. Number of results to return per page |

#### Get country

```http
  GET /countries/${id}
```

| Path Variable | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of country to fetch |

#### Get countries by name
```http
  GET /countries/?name=
```

| Query Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | Name of countries to fetch (partial search works) |
| `page`      | `string` | **Optional**. Result page to return |
| `size`      | `string` | **Optional**. Number of results to return per page |

#### Add country
```http
  POST /countries/
```
Body
```JSON
    {
        "name": "name"
    }
```

#### Update country
```http
  PATCH /countries/${id}
```

| Path Variable | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of country to update |

Body
```JSON
    {
        "name": "newName"
    }
```
#### Delete country
| Path Variable | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of country to delete |

```JSON
    {
        "name": "name"
    }
```
