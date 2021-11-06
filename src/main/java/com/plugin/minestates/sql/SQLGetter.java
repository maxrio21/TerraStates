package com.plugin.minestates.sql;

import com.plugin.minestates.Main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLGetter {

    private Main plugin;

    public SQLGetter(Main plugin) {
        this.plugin = plugin;
    }

    public void createTables() {
        PreparedStatement ps;
        try {

            /*                      BANCO                         */

            ps = plugin.SQL.getConnection().prepareStatement("" +

                    "CREATE TABLE IF NOT EXISTS Banco(" +
                    "    id int PRIMARY KEY NOT NULL," +
                    "    co_entrada int NOT NULL," +
                    "    co_retirada int NOT NULL," +
                    "    co_transferencia int NOT NULL" +
                    ");"
            );
            ps.executeUpdate();

            /*                      JUGADOR                         */

            ps = plugin.SQL.getConnection().prepareStatement("" +

                    "CREATE TABLE IF NOT EXISTS Jugador(" +
                    "    uuid varchar(200) PRIMARY KEY NOT NULL," +
                    "    nombre varchar(50) NOT NULL," +
                    "    id_banco int NOT NULL," +
                    "    FOREIGN KEY (id_banco) REFERENCES Banco(id)" +
                    ");"
            );
            ps.executeUpdate();

            /*                      CUENTA                         */

            ps = plugin.SQL.getConnection().prepareStatement("" +

                    "CREATE TABLE IF NOT EXISTS Cuenta(" +
                    "   id int PRIMARY KEY NOT NULL," +
                    "   dinero double," +
                    "   uuid_jugador varchar(200) NOT NULL," +
                    "   FOREIGN KEY (uuid_jugador) REFERENCES Jugador(uuid)" +
                    ");"
            );
            ps.executeUpdate();

            /*                      ACCION                         */

            ps = plugin.SQL.getConnection().prepareStatement("" +

                    "CREATE TABLE IF NOT EXISTS Accion(" +
                    "   id int PRIMARY KEY NOT NULL," +
                    "   nombre varchar(50) NOT NULL," +
                    "   descripcion varchar(200)" +
                    ");"
            );
            ps.executeUpdate();

            /*                      REALIZAR                         */

            ps = plugin.SQL.getConnection().prepareStatement("" +

                    "CREATE TABLE IF NOT EXISTS Realizar(" +
                    "   id_cuenta int NOT NULL REFERENCES Cuenta(id)," +
                    "   id_accion varchar(50) NOT NULL REFERENCES Accion(id)," +
                    "   uuid_jugador varchar(200) NOT NULL REFERENCES Jugador(uuid)," +
                    "   cantidad int NOT NULL," +
                    "   PRIMARY KEY (id_cuenta,id_accion,uuid_jugador)" +
                    ");"
            );
            ps.executeUpdate();

            /*                      FACTURA                         */

            ps = plugin.SQL.getConnection().prepareStatement("" +

                    "CREATE TABLE IF NOT EXISTS Factura(" +
                    "   id int PRIMARY KEY NOT NULL" +
                    ");"
            );
            ps.executeUpdate();

            /*                      FACTURAR                         */

            ps = plugin.SQL.getConnection().prepareStatement("" +

                    "CREATE TABLE IF NOT EXISTS Facturar(" +
                    "   id_cuenta int NOT NULL REFERENCES Cuenta(id)," +
                    "   uuid_jugador varchar(200) NOT NULL REFERENCES Jugador(uuid)," +
                    "   id_accion varchar(50) NOT NULL REFERENCES Accion(id)," +
                    "   fecha datetime DEFAULT CURRENT_TIMESTAMP NOT NULL," +
                    "   PRIMARY KEY (id_cuenta,id_accion)," +
                    "   UNIQUE (uuid_jugador)" +
                    ");"
            );
            ps.executeUpdate();

        }
        catch (SQLException e) {e.printStackTrace();}
    }

}
