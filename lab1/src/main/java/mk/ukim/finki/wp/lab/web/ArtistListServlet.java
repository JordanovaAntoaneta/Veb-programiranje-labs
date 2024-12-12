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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "ArtistListServlet", urlPatterns = "/artists")
public class ArtistListServlet extends HttpServlet{
    private final ArtistService artistService;
    private final SongService songService;
    private final SpringTemplateEngine springTemplateEngine;

    public ArtistListServlet(ArtistService artistService, SongService songService, SpringTemplateEngine springTemplateEngine) {
        this.artistService = artistService;
        this.songService = songService;
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
        context.setVariable("trackId", request.getParameter("trackId"));

//        Song song
//        context.setVariable("song", song);

        springTemplateEngine.process("artistsList.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String artistId = request.getParameter("artistId");
        String trackId = request.getParameter("trackId");

        songService.addArtistToSong(artistId, trackId);

        response.sendRedirect("/details?trackId="+trackId);
    }
}
