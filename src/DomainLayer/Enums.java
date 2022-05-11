package DomainLayer;

public class Enums {
    public enum ActionStatus {
        SUCCESS,
        FAIL,
        WRONG_PARAMETERS
    }

    public enum ActivationStatus {
        ACTIVE,
        INACTIVE
    }

    public enum RefereeLevel{
        Primary,
        Secondary
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

    public enum ScoreAndPositionPolicy {
        Policy_1,
        Policy_2
    }

    public enum ScheduleGamesPolicy {
        EachPairOnceASeason,
        EachPairOnceInEachHome
    }
}
