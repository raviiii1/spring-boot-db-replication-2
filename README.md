# SpringBoot DB Replication (Routing write and read queries to master and slave db respectively.)
Springboot application to demonstrate master/slave replication using AbstractRoutingDataSource.

# Pros :
1. Instead of using javax's `@Transactional` for routing, one can implement customised anotations.

# Cons :
1. It requires sufficient code changes/refactoring. You might not choose this approach for a legacy codebase.
2. Routing statagies(Round-robin, etc.) for routing query to appropriate set of master/slave dbs need to be implemented manually.
3. Scaling the cluster is not easy and might require code changes.
4. Developer has to handle the routing of read-queries to master if none of the slaves are reachable. Same for the write queries.
