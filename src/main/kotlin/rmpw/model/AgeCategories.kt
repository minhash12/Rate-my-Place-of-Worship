package rmpw.model

enum class AgeCategories(
    description: String
) {

    X0TO20("People aged between 0 and 20"),
    X21TO40("People aged between 21 and 40"),
    X41TO60("People aged between 41 and 60"),
    X61Plus("People aged over 61"),
    PREFER_NOT_TO_SAY("Prefer not to say")
}
