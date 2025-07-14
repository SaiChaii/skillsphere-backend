| Category                   | Endpoint                          | Description                                                   |
|----------------------------|----------------------------------|---------------------------------------------------------------|
| 🔐 **Auth**                | `POST /register`                 | Register a new user with roles (`MENTOR`, `LEARNER`, `BOTH`)  |
|                            | `POST /login`                    | Login users with roles (`MENTOR`, `LEARNER`, `BOTH`)          |
|                            |                                  |                                                               |
| 👤 **User Profile**        | `GET /users/{id}`                | Get user details (including their skills)                    |
|                            |                                  |                                                               |
| 🧠 **Skills**              | `POST /skills`                   | Mentor adds a skill to teach                                 |
|                            | `GET /skills`                    | Get all skills (for search, filter, explore)                 |
|                            | `GET /skills/user/{userId}`      | Get skills by a specific user (profile display)              |
|                            | `GET /skills/search?name=X`      | Search skill by name/keyword                                 |
|                            | `GET /skills/mentors?skill=X`    | Get mentors who can teach skill X                            |
|                            |                                  |                                                               |
| 🤝 **Connection Requests** | `POST /requests/connect`         | Learner sends connection request to mentor for a skill       |
|                            | `GET /requests/user/{userId}`    | Get all requests related to the user (inbox/sent)            |
|                            | `PUT /requests/{id}/accept`      | Mentor accepts a connection                                  |
|                            | `PUT /requests/{id}/reject`      | Mentor rejects a connection                                  |
|                            |                                  |                                                               |
| 📖 **My Dashboard**        | `GET /dashboard`                 | Show relevant data (skills, connections, requests)           |
