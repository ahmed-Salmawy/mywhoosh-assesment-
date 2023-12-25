package com.mywhoosh.studentresultManagment.security.repoadapter;


import com.mywhoosh.studentresultManagment.base.BaseRepoAdapter;
import com.mywhoosh.studentresultManagment.security.dto.UserDto;

import java.util.Optional;

public interface UserRepoAdapter extends BaseRepoAdapter<UserDto> {

    Optional<UserDto> getUser(String username);
}
