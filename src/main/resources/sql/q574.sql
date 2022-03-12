select b.Name from
    (
        select CandidateId, count(*) from Vote
        group by CandidateId
        order by count(*) DESC
        LIMIT 1
    ) a
        left join
    Candidate b
    on a.CandidateId = b.id