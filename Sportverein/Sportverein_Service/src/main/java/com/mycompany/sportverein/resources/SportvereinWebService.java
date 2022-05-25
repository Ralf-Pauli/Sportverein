package com.mycompany.sportverein.resources;

import database.DBSportvereinStorage;
import mitglied.Mitglied;
import sport.Mannschaft;
import sport.Sparte;
import sport.Sportart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author rpauli
 */
@Path("Verein")
public class SportvereinWebService {
    DBSportvereinStorage dbStorage;

    public SportvereinWebService() {
        dbStorage = new DBSportvereinStorage();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllMitglieder")
    public List<Mitglied> getAllMitglieder() {
        return dbStorage.getAllMitglieder();
    }

    @GET
    @Path("getAllSparten")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sparte> getAllSparten() {
        return dbStorage.getAllSparten();
    }

    @GET
    @Path("getAllSportarten")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportart> getAllSportarten() {
        return dbStorage.getAllSportarten();
    }

    @GET
    @Path("getAllMannschaften")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mannschaft> getAllMannschaften() {
        return dbStorage.getAllMannschaften();
    }

    @GET
    @Path("getMitgliederByMannschaft")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mitglied> getMitgliederByMannschaft() {
        return dbStorage.getMitgliederByMannschaft();
    }

    @GET
    @Path("getMannschaftBySportart")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Mannschaft> getMannschaftBySportart() {
        return dbStorage.getMannschaftBySportart();
    }

    @GET
    @Path("getSportartenBySparte/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sportart> getSportartenBySparte(@PathParam("id") int id) {
        return dbStorage.getSportartenBySparte(id);
    }


}
