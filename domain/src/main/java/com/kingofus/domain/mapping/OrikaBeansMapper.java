package com.kingofus.domain.mapping;

import com.kingofus.domain.UserAccount;
import com.kingofus.persistence.entities.User;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
public class OrikaBeansMapper {

    private MapperFactory factory = new DefaultMapperFactory.Builder().build();

    public OrikaBeansMapper() {
        registerMapperFacade();
    }

    public <T> T map(Object source, Class<T> target){
        return factory.getMapperFacade().map(source,target);
    }

    public UserAccount mapUserToUserAccount(User user) {
        return factory.getMapperFacade().map(user, UserAccount.class);
    }

    public User mapUserAccountToUser(UserAccount userAccount) {
        return factory.getMapperFacade().map(userAccount, User.class);
    }

    private void registerMapperFacade() {
        factory.classMap(User.class, UserAccount.class)
                .customize(new CustomMapper<User, UserAccount>() {
                    @Override
                    public void mapAtoB(User user, UserAccount userAccount, MappingContext context) {
                        userAccount.setEmail(user.getEmail());
                        userAccount.setFullName(new StringJoiner(" ")
                                .add(user.getFirstName())
                                .add(user.getLastName()).toString());
                        userAccount.setBirthDate(user.getBirthDate());
                        userAccount.setLastLogin(user.getLastLogin());
                        userAccount.setPassword(user.getPassword());
                    }

                    @Override
                    public void mapBtoA(UserAccount userAccount, User user, MappingContext context) {
                        user.setEmail(userAccount.getEmail());
                        String[] nameParts = userAccount.getFullName().split("\\s+");
                        user.setFirstName(nameParts[0]);
                        user.setLastName(nameParts[1]);
                        user.setBirthDate(userAccount.getBirthDate());
                        user.setPassword(userAccount.getPassword());
                    }
                })
                .register();
    }
}
