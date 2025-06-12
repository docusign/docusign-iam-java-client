# Party

A party is a person, group, or organization that is involved in a contract and has legally binding obligations and responsibilities. They also seek to benefit from the agreement.



## Fields

| Field                                                                  | Type                                                                   | Required                                                               | Description                                                            |
| ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------------------------------- |
| `id`                                                                   | *String*                                                               | :heavy_check_mark:                                                     | Unique identifier for the party, mapped to the party entity reference. |
| `nameInAgreement`                                                      | *JsonNullable\<String>*                                                | :heavy_minus_sign:                                                     | Name of the party as it appears in the agreement.                      |
| `preferredName`                                                        | *JsonNullable\<String>*                                                | :heavy_minus_sign:                                                     | Formal name of the party.                                              |