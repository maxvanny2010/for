package forum.control;

import forum.model.Post;
import forum.service.post.PostAdminService;
import forum.service.post.PostService;
import forum.service.post.PostUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

/**
 * CabinetControl.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/18/2020
 */
@Controller
public class CabinetControl {
    /**
     * field a service user.
     */
    private final PostService postUser;
    /**
     * field a service admin.
     */
    private final PostAdminService postAdmin;

    /**
     * Constructor.
     *
     * @param aPostsAdmin admin
     * @param aPostsUser  user
     */
    public CabinetControl(final PostUserService aPostsUser,
                          final PostAdminService aPostsAdmin) {
        this.postUser = aPostsUser;
        this.postAdmin = aPostsAdmin;
    }

    /**
     * Method  to get.
     *
     * @param name  a name
     * @param model a model
     * @return page
     */
    @GetMapping("/cabinet")
    public String cabinet(@RequestParam(value = "name") final String name,
                          final Model model) {
        final SecurityContext context = SecurityContextHolder.getContext();
        final Authentication auth = context.getAuthentication();
        final String names = auth.getName();

/*  п. 5 комменты:
    секурити изменил как ты написал.
    но без этой проверки всё равно могу попасть в кабинет админа,
    если изменить значение name=user на name=admin в адресе кабинета

        if (Objects.isNull(name) || !Objects.equals(names, name)) {
            return "redirect:/404";
        }
*/
        List<Post> posts;
        if (Objects.equals("admin", name)) {
            posts = this.postAdmin.getAll();
        } else {
            posts = this.postUser.getAll(name);
        }
        model.addAttribute("posts", posts);
        model.addAttribute("name", name);
        return "cabinet";
    }
}
