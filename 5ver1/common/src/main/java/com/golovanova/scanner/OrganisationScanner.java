package com.golovanova.scanner;


import com.golovanova.data.DataSource;
import com.golovanova.model.Organization;
import com.golovanova.model.OrganizationType;

public class OrganisationScanner {
    private final DataSource dataSource;
    private EnumScanner<OrganizationType> organizationTypeScanner;

    public OrganisationScanner(DataSource dataSource) {
        this.dataSource = dataSource;
        organizationTypeScanner = new EnumScanner<>(dataSource, OrganizationType.class);
    }

    public Organization scan() throws Exception {
        System.out.println("Input organisation's data: ");
        System.out.println("Input name: ");
        String name = dataSource.nextLine();
        while (name.trim().equals("")) {
            System.out.println("Name is consist of \" \", please enter the normal one!");
            name = dataSource.nextLine();
        }
        System.out.println("Input employees count: ");
        Long employeesCount = dataSource.nextLong();
        OrganizationType type = organizationTypeScanner.scanEnum();

        Organization organization = new Organization(employeesCount, type, name);

        return organization;
    }
}
