package model.entity;

/**
 * Created by daniel on 1/29/17.
 */
public enum Roles {
    CLIENT(1),BOOKMAKER(2),ADMIN(3);

    private Integer roleId;

    Roles(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }
}
