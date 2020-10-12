package spring.dependency.lookup.domain;

import spring.dependency.lookup.annotation.Super;

/**
 * 超级用户
 *
 * @author pengxing on 2020/9/28
 */
@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
