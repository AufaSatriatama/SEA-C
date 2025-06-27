package db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})

@RestController
@RequestMapping("/Testimonials")

public class TestimonialsController {
    @Autowired
    private TestimonialsRepository repo;

    @GetMapping
    public List<Testimonials> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Testimonials addTestimonials(@RequestBody Testimonials testimonials) {
        if (testimonials.getName().isEmpty() || testimonials.getMessage().isEmpty() || testimonials.getRating() <= 0){
            throw new IllegalArgumentException();
        }
        return repo.save(testimonials);
    }

    //Hapus data null
    @DeleteMapping("/delete-invalid")
    public void deleteInvalidTestimonials() {
        List<Testimonials> all = repo.findAll();
        for (Testimonials t : all) {
            if (t.getName() == null || t.getMessage() == null || t.getRating() == 0) {
                repo.delete(t);
            }
        }
    }

    //Hapus data terakhir 
    @DeleteMapping("/delete-last")
    public void deleteLastTestimonial() throws Exception{
        try {
            List<Testimonials> all = repo.findAll();
            Testimonials lastTestimonial = all.get(all.size()-1);
            repo.delete(lastTestimonial);  
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}




@Configuration
class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*");
            }
        };
    }
}
