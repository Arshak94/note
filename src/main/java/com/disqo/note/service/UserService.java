package com.disqo.note.service;

import com.disqo.note.binding.UserPayload;
import com.disqo.note.model.User;

public interface UserService {
    User create(UserPayload userPayload);
}
