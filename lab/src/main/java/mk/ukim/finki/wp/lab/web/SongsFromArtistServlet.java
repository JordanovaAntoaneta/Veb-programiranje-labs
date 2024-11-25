package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SongsFromArtistServlet", urlPatterns = "/songsFromArtist")
public class SongsFromArtistServlet extends HttpServlet {
    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;


    public SongsFromArtistServlet(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(request.getServletContext())
                .buildExchange(request, response);

        WebContext context = new WebContext(webExchange);

        List<Artist> artists = artistService.listArtists();
        context.setVariable("artists", artists);

        List<Song> songs = songService.listSongs();

        springTemplateEngine.process("songsFromArtist.html", context, response.getWriter());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        songService.listSongs().stream().filter(s -> s.getPerformers().stream().filter(p -> p.getFirstName() == firstName && p.getLastName()==lastName).isParallel()).findAny();
        response.sendRedirect("/artists");
    }
}
