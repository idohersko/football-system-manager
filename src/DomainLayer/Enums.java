package DomainLayer;

public class Enums {
    public enum ActionStatus {
        SUCCESS,
        FAIL
    }

    public enum ActivationStatus {
        ACTIVE,
        INACTIVE
    }

    public enum UserType {
        Coach,
        Fan,
        Player,
        Referee,
        SystemAdmin,
        TeamManager,
        TeamOwner
    }

    public enum EventType {
        Goal,
        Offside,
        Offense,
        RedCard,
        YellowCard,
        Injury,
        Substitution
    }
}
