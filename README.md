# LEARNING PLATFORM BACKEND
Learning Platform Project using Java Spring Boot to deploy API web services

# DataBase Configuration
Current project use PostgreSQL 15.2

attach the sql sequence in order to create Tables and insert the Courses and categories

![image](https://github.com/ajmedinabalboa/learningplatformbackend/assets/132222019/cbce615a-3071-443e-9d84-408bb1b77312)
Only use 4 tables Categories, Courses, Enrollments and Students

1.- Create the DataBase "Learning Platform" using script:

CREATE DATABASE "LearningPlatform"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Bolivia.1252'
    LC_CTYPE = 'Spanish_Bolivia.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
    
2.- Create Table "Categories"

-- Table: public.Categories

-- DROP TABLE IF EXISTS public."Categories";

CREATE TABLE IF NOT EXISTS public."Categories"
(
    "idCategory" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999 CACHE 1 ),
    "categoryDescription" character varying(150) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "Categories_pkey" PRIMARY KEY ("idCategory")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Categories"
    OWNER to postgres;
    
3.- Create Table "Courses"

-- Table: public.Courses

-- DROP TABLE IF EXISTS public."Courses";

CREATE TABLE IF NOT EXISTS public."Courses"
(
    "idCourse" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999 CACHE 1 ),
    "idCategory" bigint NOT NULL,
    "courseDescription" character varying(150) COLLATE pg_catalog."default" NOT NULL,
    abstract character varying(3000) COLLATE pg_catalog."default" NOT NULL,
    author character varying(100) COLLATE pg_catalog."default" NOT NULL,
    "startDate" timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "endDate" timestamp without time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    rate character varying(10) COLLATE pg_catalog."default",
    attendance integer,
    "totalHours" character varying(10) COLLATE pg_catalog."default",
    CONSTRAINT "Courses_pkey" PRIMARY KEY ("idCourse"),
    CONSTRAINT "idCategory_fk" FOREIGN KEY ("idCategory")
        REFERENCES public."Categories" ("idCategory") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Courses"
    OWNER to postgres;

4.- Create Table "Enrollments"

-- Table: public.Enrollments

-- DROP TABLE IF EXISTS public."Enrollments";

CREATE TABLE IF NOT EXISTS public."Enrollments"
(
    "idEnrollment" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 99999999 CACHE 1 ),
    "idStudent" bigint NOT NULL,
    "idCourse" bigint NOT NULL,
    "enrollmentDate" timestamp without time zone NOT NULL,
    "isCancelled" boolean NOT NULL DEFAULT false,
    "cancellationReason" character varying(500) COLLATE pg_catalog."default",
    CONSTRAINT "Enrollments_pkey" PRIMARY KEY ("idEnrollment"),
    CONSTRAINT "idStudent_fk" FOREIGN KEY ("idStudent")
        REFERENCES public."Students" ("idStudent") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Enrollments"
    OWNER to postgres;
    
5.- Create Table "Students"

-- Table: public.Students

-- DROP TABLE IF EXISTS public."Students";

CREATE TABLE IF NOT EXISTS public."Students"
(
    "idStudent" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 999999999 CACHE 1 ),
    "fullName" character varying(200) COLLATE pg_catalog."default" NOT NULL,
    "birthDate" timestamp without time zone,
    "dataCreated" timestamp without time zone DEFAULT CURRENT_TIMESTAMP,
    "lastLogin" timestamp without time zone,
    password character varying(100) COLLATE pg_catalog."default" NOT NULL,
    username character varying(100) COLLATE pg_catalog."default" NOT NULL,
    "phoneNumber" character varying(20) COLLATE pg_catalog."default",
    country character varying(20) COLLATE pg_catalog."default",
    gender character varying(10) COLLATE pg_catalog."default",
    address character varying(100) COLLATE pg_catalog."default",
    language character varying(20) COLLATE pg_catalog."default",
    "educationLevel" character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT "Stundents_pkey" PRIMARY KEY ("idStudent")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Students"
    OWNER to postgres;
    
6.- Insert Data into "Categories" Table using script

INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (1, 'Mobile App Development');
INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (2, 'Web Programming/Web Design');
INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (3, 'Artificial Intelligence');
INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (4, 'Data Analytics');
INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (5, 'DevOps');
INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (6, 'UI/UX Development');
INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (8, 'Cyber Security');
INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (9, 'Software Quality Testing');
INSERT INTO public."Categories" ("idCategory", "categoryDescription") OVERRIDING SYSTEM VALUE VALUES (7, 'Programming');

7.- Insert Data into "Courses" Table using script

INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (6, 1, 'Android Layout Fundamentals', 'Understand the basic Android layout classes, and how to use them effectively.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (1, 1, 'Android: Room Fundamentals', 'Dealing with local storage of data in an extendable way has always been a challenge, but Google has introduced a new option: Room. You will learn how to deal with the database for local storage in an easy way without hampering the user experience.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-05-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (2, 1, 'Flutter 2: The Big Picture', 'This course is an overview of the Flutter framework. You will find best practices and tips for developers and designers. You will also find tools to get a head start in case you decide to use Flutter in your professional life.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-05-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (3, 1, 'Developing Android Applications with Kotlin: Getting Started', 'Kotlin greatly simplifies the task of creating Android apps. Become a successful Android developer by developing your understanding of the Kotlin language and the creation of interactive user experiences with Android Activities.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (4, 1, 'iOS App Development: The Big Picture', 'This course will show you a high level introduction to the iOS ecosystem, the Swift programming language, Apples Xcode IDE, so you can walk away with the fundamental principles, patterns, and techniques needed to build iOS applications.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (5, 1, 'Firebase on Android: Cloud Firestore', 'Firebase has announced Cloud Firestore as its new flagship database. In this course you will learn how to use Firestore to manage your application data with its unique document-oriented design.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (7, 1, 'Xamarin.Forms: The Big Picture', 'Xamarin.Forms extends the Xamarin framework with a shared abstraction of the common UI objects of each platform. In this course, you will learn foundational knowledge to help you decide if Xamarin.Forms can help with your cross-platform development.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (13, 2, 'Angular 14: The Big Picture', 'This course will teach you the high-level benefits, architecture, and latest features of Angular.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (8, 1, 'Introduction to Xamarin.Forms 4', 'Learn the skills necessary to create multi-platform applications with Xamarin.Forms that provide a rich user experience and run natively across iOS, Android, and Universal Windows Platform (UWP) from a single, shared C# code base.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (9, 1, 'Build Mobile Web Applications With Flutter', 'Flutter is an application framework used for building beautiful, natively compiled apps for mobile, web, and desktop from a single codebase. Develop fast with fully-customizable widgets and Stateful Hot Reload, ship features quickly with an expressive and flexible UI, and get full native performance with widgets that incorporate all critical platform differences.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (10, 2, 'Building Websites with HTML, CSS and JavaScript', 'HyperText Markup Language (HTML), Cascading Style Sheets (CSS), and JavaScript are three separate languages that work together to create web pages and web applications. HTML creates structure, CSS styles the markup, and JavaScript creates interactivity.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (11, 2, 'Understand a Sites Traffic Using Google Analytics', 'Google Analytics helps you make actionable decisions that can have a dramatic impact on engagement and conversions. This course will teach you how to add Google Analytics to a website, create custom campaigns, and evaluate the results via reports.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (12, 2, 'Styling the Web with Bootstrap', 'Bootstrap is a free and open-source CSS framework directed at responsive, mobile-first front-end web development. It contains CSS and JavaScript-based design templates for typography, forms, buttons, navigation, and other interface components. It can be used to rapidly prototype ideas and build high-performance enterprise websites.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (14, 2, 'Unit Testing in Angular 12', 'Automated tests are an important ingredient in a successful project. This course will teach you everything you need to know to unit test your Angular projects, including testing services, component templates, and dealing with asynchronous code.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (15, 2, 'Angular Reactive Forms', 'You can build forms in Angular by using a Reactive approach by defining the form model and validation in your component code. This course details how to build Reactive forms, validate user-entered data, and save that data using HTTP.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (16, 2, 'React: The Big Picture', 'Interested in React? This course explores why React is worth considering, tradeoffs to consider, and reasons React may, or may not be the right fit for you.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (17, 2, 'Building Applications with React 17 and Redux', 'Learn how to use React, Redux, React Router, and modern JavaScript to build an app with React. Use Webpack, Babel, Jest, React Testing Library, Enzyme, and more to build a custom React development environment and build process from the ground up.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (18, 2, 'Building Forms with Vue 3', 'This course will teach you how to build, compose, and validate forms using Vue.js.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (19, 2, 'Vue 3 Router', 'This course will teach you the intricacies of adding navigation to your Vue.js web applications using the Vue Router, a powerful tool for creating dynamic and responsive navigation experiences.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (20, 3, 'Getting Started with Amazon Lex', 'Gain the knowledge on how to build in user interactions for the applications you create with this foundational course on Amazon Lex.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (21, 4, 'Representing, Processing, and Preparing Data', 'This course covers the different data processing tools - including spreadsheets, Python, and relational databases - and deals with data quality issues and visualizing data for insight generation.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (22, 5, 'DevOps Foundations: Core Concepts and Fundamentals', 'The old gap between development and IT is bridged with DevOps. This course will teach you what the shape and form of the bridge between the two technical worlds, and how to make it happen in your enterprise.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (23, 6, 'UX Strategy Fundamentals', 'UX Strategy is key to the success of a product. In this course, you will learn how to leverage unmet consumer needs in an agile culture to design a Minimum Awesome Product (MAP).', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (24, 6, 'UX Role and Impact on Organizations', 'Learning about how to be an experience designer is more than just learning about tools and practices. In this course, you will learn what the role looks like in the context of a company, which is just as important as the tools and practices.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (25, 7, 'Functional Programming with C#', 'Learn how to take advantage of several functional programming techniques including immutability, higher-order functions, and functional pipelining within your existing C# projects.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (26, 7, 'C# 10 Fundamentals', 'C# 10 is the preferred language to build .NET applications. In this course, you will learn the basics of the C# language and create your own C# applications', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (27, 7, 'Java SE 17 Fundamentals', 'Java is one of the most in-demand and widely-used programming languages in the world. This course will teach you everything you need to know to get started programming in Java.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (28, 7, 'Java SE 17 Advanced Language Features', 'You want to deepen your knowledge as a Java developer. This course will teach you Java 17 beyond the fundamentals, and you will learn how to use records, sealed classes, lambda expressions, annotations, generics, and other Java features effectively.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (29, 7, 'Spring Framework: Spring 5 Fundamentals', 'This course is designed to give you a solid foundation of the fundamentals of the Spring Framework. It covers how to get started as well as advanced configuration techniques with Spring using the most recent versions.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (30, 8, 'Security Principles for CCsm', 'This course will teach you security concepts of information protection and assurance needed for the Certified in Cybersecurity Exam.', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');
INSERT INTO public."Courses" ("idCourse", "idCategory", "courseDescription", abstract, author, "startDate", "endDate", rate, attendance, "totalHours") OVERRIDING SYSTEM VALUE VALUES (31, 9, 'Getting Started with UI Testing and Appium 1', 'This course you will teach you how to write UI Test automation in the programming language you like for applications on iOS, Android, Mac, and Windows including UWP, WPF, and Windows Forms applications using the open source tool Appium', 'Alvaro Javier Medina Balboa', '2023-05-23 20:11:01.86574', '2023-06-23 20:11:01.86574', '4.5', 422, '3:20hs');

# JAVA SPRING BOOT Configuration
- Change the password for the "application.properties" file to the admin password configure during PostgreSql installation.
- Run the LearningplatformApplication.java
- This project use JWT Configuration of Token Authentication during calls API endpoints
- This project expose a Swagger UI using Open API. 

# Images
![image](https://github.com/ajmedinabalboa/learningplatformbackend/assets/132222019/614d3f9e-a1d6-40ab-8597-6045a22214be)

