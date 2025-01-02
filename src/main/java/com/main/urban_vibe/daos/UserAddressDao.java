package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.UserAddress;
import java.util.List;

public interface UserAddressDao {
    List<UserAddress> getList();
    UserAddress getById(Long id);
    UserAddress create(UserAddress userAddress);
    UserAddress update(UserAddress userAddress);
    void delete(Long id);

    List<UserAddress> getUserAddressesByUserId(Long userId);
    UserAddress findDefaultAddressByUserId(Long userId);
}