package test;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class FacultyServerResource extends ServerResource {
    @Get("json")
    public Faculty present() {
        String facultyName = getAttribute("facultyName");

        Faculty faculty = new Faculty();
        faculty.setName(facultyName);
        faculty.setPost("post");
        // something else

        return faculty;
    }
}
