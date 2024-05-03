package RecetteController;

@Controller
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @GetMapping("/recettes")
    @ResponseBody
    public Iterable<Recette> getAllRecettes() {
        return recetteService
    }
}