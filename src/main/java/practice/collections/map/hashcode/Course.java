package practice.collections.map.hashcode;

import java.util.List;
import java.util.Date;

public class Course {

    private final String uuid;

    private final String name;

    private final List<Session> sessions;

    public Course(final String uuid, final String name, final List<Session> sessions) {
        this.uuid = uuid;
        this.name = name;
        this.sessions = sessions;
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    @Override
    public boolean equals(final Object object) {
        if (!(object instanceof Course))
            return false;

        final Course that = (Course) object;
        if (!that.getUuid().equals(this.getUuid()))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        // BEGIN (write your solution here)
        if (uuid == null || uuid.isEmpty()) {
            return 0;
        }
        char val[] = uuid.toCharArray();
        int h = 0;
        for (int i = 0; i < uuid.length(); i++) {
            h = h + val[i];
        }
        return h;
        // END
    }

    public class Session {

        private final Date startDate;

        public Session(final Date startDate) {
            this.startDate = startDate;
        }

        public Date getStartDate() {
            return this.startDate;
        }

        public Course getCourse() {
            return Course.this;
        }

        @Override
        public boolean equals(final Object object) {
            if (!(object instanceof Session)) return false;

            final Session that = (Session) object;
            if (!that.getStartDate().equals(this.getStartDate())) return false;

            if (!that.getCourse().equals(this.getCourse())) return false;

            return true;
        }

        @Override
        public int hashCode() {
            // BEGIN (write your solution here)
            return startDate.hashCode();
            // END
        }

    }

}
