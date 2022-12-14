## Consuming-REST-API
Building an application that creates a REST API to consume another external REST API and store it in static memory.


## REST API
In this project, the Harry Potter REST API was used as an External API
#### url: https://hp-api.onrender.com/api/spells
--------------------------------------------------------------------
### [ Request ]
## [ Get List of Spells Aloccated in Memory ]
`GET harrypotter/spells/`

   `http://localhost:8080/harrypotter/spells`
   
### [ Response ]

    Request Method: GET
    Status Code: 200
    Date: Sat, 22 Oct 2022 17:51:36 GMT
    Content-Type: application/json

   ```json
  [
    {
        "id": 0,
        "name": "Aberto",
        "description": "Opens locked doors"
    },
    {
        "id": 1,
        "name": "Accio",
        "description": "Summons objects"
    },
    {
        "id": 2,
        "name": "Aguamenti",
        "description": "Summons water"
    },
    {
        "id": 3,
        "name": "Alohomora",
        "description": "Unlocks objects"
    }
  ]
    
```
--------------------------------------------------------------------
### [ Request ]
## [ Create a new spell in Memory ]

`POST harrypotter/spells/`

   `http://localhost:8080/harrypotter/spells`
    
    
   ```json
   {
    "name": "Dragon Flame",
    "description": "Burns everything around"
   }
   ```
### [ Response ]

    Request Method: POST
    Status Code: 201
    Date: Sat, 22 Oct 2022 18:13:36 GMT
    Content-Type: application/json
    

   ```json
   {
    "id": 77,
    "name": "Dragon Flame",
    "description": "Burns everything around"
   }
   ```
--------------------------------------------------------------------   
### [ Request ]
## [ Update a Spell in Memory ]

`PUT harrypotter/spells/{id}`

   `http://localhost:8080/harrypotter/spells/{id}`
   
   ```json
   {
    "name": "Rasengan",
    "description": "a ball of chakra that spins at extremely high speed"
   }
   ```
   
### [ Response ]

    Request Method: PUT
    Status Code: 200
    Date: Sat, 22 Oct 2022 20:41:15 GMT
    Content-Type: application/json

   ```json
   {
    "id": 0,
    "name": "Rasengan",
    "description": "a ball of chakra that spins at extremely high speed"
   }
   ```
--------------------------------------------------------------------   
### [ Request ]
## [ Delete a spell in Memory ]

`DELETE harrypotter/spells/{id}`

   `http://localhost:8080/harrypotter/spells/{id}`
   
### [ Response ]

    Request Method: DELETE
    Status Code: 200
    Date: Sat, 22 Oct 2022 20:52:24 GMT
    Content-Type: application/json
    
    
   ```Spell Deleted```
    
    
    
