/* 
 * @author Paulina Urbas
 * @version 2.0
 */
package annotaction;
import java.lang.annotation.*;
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
/**
 * Simple adnotation to register when uses in program 
 * @author Paulina Urbas
 * @version 2.0
 */
public @interface UseCase {
    /** Simple enum to find color of importance;
     *  red is the most important 
     *  white is the least important 
     *  @author Paulina Urbas
     *  @version 2.0
     */
    public enum Importance {
        RED, YELLOW, GREEN, WHITE
    };
    /** Importnace 
     *  @author Paulina Urbas
     *  @version 2.0
     * @return default color is white, it means it the least important
     */
    Importance importance() default Importance.WHITE;
    /**
     * int value how many times method was used
     * @return id of UseCase
     *  @author Paulina Urbas
     *  @version 2.0
     */
    public int id();
    /**
     * despription, default is no description 
     * @return descprition
     *  @author Paulina Urbas
     *  @version 2.0
     */
    public String descprition() default "no desription";
    /**
     * int value how many times method was used
     * @return author
     *  @author Paulina Urbas
     *  @version 2.0
     */
    public String author();
 
    
}
