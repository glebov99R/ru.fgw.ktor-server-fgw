package ru.fgw.plugins

import io.ktor.server.application.*
import java.sql.DriverManager

fun sqlConnection(){

    val jdbcUrl = "jdbc:jtds:sqlserver://192.168.0.12:1433;databaseName=AF_Svet_Testing;" // URL-адрес JDBC для подключения к базе данных MS SQL Server
    val dbUser = "oper" // Имя пользователя базы данных
    val dbPassword = "oper" // Пароль базы данных

    // Создание соединения с базой данных
    val connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)

}