# SpringBoot-API

## Endpoints API:

### GET:
    - Récupérer tous les étudiants: ```http://localhost:8080/students```
    - Récupérer un étudiant selon son id: ```http://localhost:8080/students/{id_etudiant}```
    - Récupérer tous les cours: ```http://localhost:8080/courses```
    - Récupérer un cours selon son id: ```http://localhost:8080/courses/{id_cours}```
    - Récupérer les notes d'un étudiant: ```http://localhost:8080/grades/student/{id_etudiant}```
    - Récupérer les cours d'un étudiant: ```http://localhost:8080/grades/cours/{id_cours}```
    - Récupérer la moyenne des notes d'un cours: ```http://localhost:8080/reports/course/{id_cours}```
    - Récupérer la moyenne des notes d'un étudiant: ```http://localhost:8080/reports/student/{id_etudiant}```

### POST:
    - Ajouter un nouvel étudiant: ```http://localhost:8080/students```` 
    exemple de contenu à mettre dans le body: { "prenom": "Axel", "nom": "D", "email": "axel-d@zzz.cd", "age": 20 }
    - Ajouter un nouveau cour: ```http://localhost:8080/courses````
    exemple de contenu à mettre dans le body: { "nameCours": "Java", "nameProf": "Mr Java" }
    - Ajouter une nouvelle note: ```http://localhost:8080/grades````
    exemple de contenu à mettre dans le body: { "studentId": "1", "coursId": "2", "value": 20 }

### PUT:
    - Modifier les informations d'un étudiant: ```http://localhost:8080/students/{id_etudiant}````
    exemple de contenu à mettre dans le body: { "prenom": "Baptiste", "nom": "Mathon" }
    - Modifier un cours: ```http://localhost:8080/courses/{id_cour}````
    exemple de conetnu à mettre dans le body: { "nameCours": "Math 2" }
    - Modifier une note: ```http://localhost:8080/grades/{id_note}````
    exemple de contenu à mettre dans le body: { "value": 18 }


### DELETE:
    - Supprimer un étudiant: ```http://localhost:8080/students/{id_etudiant}````
    - Supprimer un cours: ```http://localhost:8080/courses/{id_cours}```
    - Supprimer une note: ```http://localhost:8080/grades/{id_note}```