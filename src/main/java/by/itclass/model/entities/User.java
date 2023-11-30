package by.itclass.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class User {
    private int id;
    @NonNull
    private String login;
    @NonNull
    private String name;
    @NonNull
    private String email;

}
