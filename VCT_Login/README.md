## API Information 

---

### 회원 처리 (auth/user)

<details>
<summary>1. 회원 가입 (POST)</summary>

### Request Form

|     TAG     |  value  | required |
| :---------: | :-----: | :------: |
|   API URL   |  auth/user  |    -     |
|   Method    |  POST   |    -     |
|   email   | String  |    ✔️    |
|  password  | String  |    ✔️    |
|  nick  | String  |    ✔️    |
| phone | String |    ✔️    |


### Response Form

#### Success : True 
|   TAG   | value  |         Example          |
| :-----: | :----: | :----------------------: |
| success | Boolean |          True           |


</details>

<details>
<summary>2. 회원 조회 (GET)</summary>

### Request Form

|       TAG        | value  | required |
| :--------------: | :----: | :------: |
|     API URL      | auth/user  |    -     |
|      Method      |  GET   |    -     |
| sessionid (inCookie) | String |    ✔️    |

### Response Form

|    TAG    | value  |          Example           |
| :-------: | :----: | :------------------------: |
|  success  | Boolean |           True             |
|   email   | String  |    99junsung@gmail.com    |
|  nick  | String  |   junseong     |
| phone | String |    010-0000-0000    |

</details>

<details>
<summary>3. 회원 수정 (PUT)</summary>

### Request Form

|       TAG        | value  | required |
| :--------------: | :----: | :------: |
|     API URL      | auth/user  |    -     |
|      Method      |  PUT   |    -     |
| sessionid (inCookie) | String |    ✔️    |
|   email   | String  |   -     |
|  nick  | String  |    -    |
| phone | String |    -    |


### Response Form

|    TAG    | value  |          Example           |
| :-------: | :----: | :------------------------: |
|  success  | Boolean |           True             |

</details>

<details>
<summary>4. 회원 삭제 (DELETE)</summary>

### Request Form

|       TAG        | value  | required |
| :--------------: | :----: | :------: |
|     API URL      | auth/user  |    -     |
|      Method      |  DELETE   |    -     |
| sessionid (inCookie) | String |    ✔️    |



### Response Form

|    TAG    | value  |          Example           |
| :-------: | :----: | :------------------------: |
|  success  | Boolean |           True             |
|   email   | String  |    99junsung@gmail.com    |


</details>

### 회원 로그인 (auth/login)
<details>
<summary>1. 로그인 (POST)</summary>

### Request Form

|       TAG        | value  | required |
| :--------------: | :----: | :------: |
|     API URL      | auth/login  |    -     |
|      Method      |  POST   |    -     |
| sessionid (inCookie) | String |    ✔️    |



### Response Form

|    TAG    | value  |          Example           |
| :-------: | :----: | :------------------------: |
|  success  | Boolean |           True             |
|   email   | String  |    99junsung@gmail.com    |


</details>

### 회원 로그아웃 (auth/logout)

<details>
<summary>1. 로그아웃 (POST)</summary>

### Request Form

|       TAG        | value  | required |
| :--------------: | :----: | :------: |
|     API URL      | auth/logout  |    -     |
|      Method      |  POST   |    -     |
| sessionid (inCookie) | String |    ✔️    |



### Response Form

|    TAG    | value  |          Example           |
| :-------: | :----: | :------------------------: |
|  success  | Boolean |           True             |


</details>