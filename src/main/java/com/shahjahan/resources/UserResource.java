package com.shahjahan.resources;

import com.shahjahan.api.User;
import com.shahjahan.core.UserRowMapper;
import org.jdbi.v3.core.Jdbi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    final Jdbi jdbi;

    public UserResource(Jdbi jdbi) {
        this.jdbi = jdbi;
        this.jdbi.registerRowMapper(new UserRowMapper());

    }

    @GET
    public List<User> getUser() {

        return this.jdbi.withHandle(handle -> handle.createQuery("SELECT * FROM user")
                .mapTo(User.class).list()
        );
    }
}
