# SpringBoot DB Replication (Routing write and read queries to master and slave db respectively.)
Springboot application to demonstrate master/slave replication using AbstractRoutingDataSource.

# Cons :
1. It requires sufficient code changes/refactoring. You might not choose this approach for a legacy codebase.
2. Routing statagies(Round-robin, etc.) for routing query to appropriate set of master/slave dbs need to be implemented manually.
3. Scaling the cluster is not easy and might require code changes.
