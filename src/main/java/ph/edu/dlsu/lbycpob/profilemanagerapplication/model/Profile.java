package ph.edu.dlsu.lbycpob.profilemanager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile profile)) return false;
        return Objects.equals(id, profile.id)
                && Objects.equals(name, profile.name)
                && Objects.equals(status, profile.status)
                && Objects.equals(quote, profile.quote)
                && Objects.equals(picture, profile.picture)
                && Objects.equals(createdAt, profile.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, quote, picture, createdAt);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", quote='" + quote + '\'' +
                ", picture='" + picture + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    /**
     * Manual replacement for Lombok's @Builder. Fields with DB-side
     * defaults (status, quote, picture) are pre-seeded here so that
     * Profile.builder().name("x").build() still satisfies the NOT NULL
     * constraints on those columns even if the caller never sets them --
     * mirroring what @Builder.Default previously guaranteed.
     */
    public static final class Builder {
        private UUID id;
        private String name;
        private String status = "";
        private String quote = "";
        private String picture = "https://6fkrqtkwbcnqsois.public.blob.vercel-storage.com/avatars/default.webp";
        private OffsetDateTime createdAt;

        private Builder() {
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder quote(String quote) {
            this.quote = quote;
            return this;
        }

        public Builder picture(String picture) {
            this.picture = picture;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Profile build() {
            return new Profile(id, name, status, quote, picture, createdAt);
        }

        public String getName() {
            return name;
        }

        public UUID getId() {
            return id;
        }


    }
}