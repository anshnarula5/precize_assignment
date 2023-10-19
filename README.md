<div align="center">
<h1 align="center">
<img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="100" />
<br>PRECIZE_ASSIGNMENT</h1>
<h3>◦ Developed with the software and tools below.</h3>

<p align="center">
<img src="https://img.shields.io/badge/SVG-FFB13B.svg?style&logo=SVG&logoColor=black" alt="SVG" />
<img src="https://img.shields.io/badge/JavaScript-F7DF1E.svg?style&logo=JavaScript&logoColor=black" alt="JavaScript" />
<img src="https://img.shields.io/badge/HTML5-E34F26.svg?style&logo=HTML5&logoColor=white" alt="HTML5" />
<img src="https://img.shields.io/badge/Bootstrap-7952B3.svg?style&logo=Bootstrap&logoColor=white" alt="Bootstrap" />

<img src="https://img.shields.io/badge/React-61DAFB.svg?style&logo=React&logoColor=black" alt="React" />
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style&logo=openjdk&logoColor=white" alt="java" />
<img src="https://img.shields.io/badge/Markdown-000000.svg?style&logo=Markdown&logoColor=white" alt="Markdown" />
<img src="https://img.shields.io/badge/JSON-000000.svg?style&logo=JSON&logoColor=white" alt="JSON" />
</p>
<img src="https://img.shields.io/github/license/anshnarula5/precize_assignment?style&color=5D6D7E" alt="GitHub license" />
<img src="https://img.shields.io/github/last-commit/anshnarula5/precize_assignment?style&color=5D6D7E" alt="git-last-commit" />
<img src="https://img.shields.io/github/commit-activity/m/anshnarula5/precize_assignment?style&color=5D6D7E" alt="GitHub commit activity" />
<img src="https://img.shields.io/github/languages/top/anshnarula5/precize_assignment?style&color=5D6D7E" alt="GitHub top language" />
</div>




## 📍 Overview

Precize Assignment for Student SAT score CRUD operation

---



## 📂 Repository Structure

```sh
└── precize_assignment/
    ├── backend/
    │   ├── .gitignore
    │   ├── .mvn/
    │   ├── mvnw
    │   ├── mvnw.cmd
    │   ├── pom.xml
    │   └── src/
    └── client/
        ├── .gitignore
        ├── package-lock.json
        ├── package.json
        ├── public/
        ├── README.md
        └── src/
```

## Getting started

1. Clone the precize_assignment repository:
```sh
git clone https://github.com/anshnarula5/precize_assignment
```

2. Change to the project directory:
```sh
cd precize_assignment
```

3. Install client Dependencies:
```sh
cd client
npm i
```

4. Install Backend Dependencies:
```sh
cd backend
mvn clean install
```

4. Create a mySql connection:
```sh
username : satresult
password : satresult
db connection name : student_sat_scores_db
```
Create a table : `student_sat_score`
```sh
DROP TABLE IF EXISTS `student_sat_score`;

CREATE TABLE student_sat_score (
    student_name VARCHAR(255) PRIMARY KEY NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    pincode VARCHAR(10) NOT NULL,
    sat_score DECIMAL(5, 2) CHECK (sat_score >= 0 AND sat_score <= 100) NOT NULL,
    passed BOOLEAN
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


```
